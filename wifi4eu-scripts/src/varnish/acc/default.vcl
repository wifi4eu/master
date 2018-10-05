#
# This is an example VCL file for Varnish.
#
# It does not do anything by default, delegating control to the
# builtin VCL. The builtin VCL is called when there is no explicit
# return statement.
#
# See the VCL chapters in the Users Guide at https://www.varnish-cache.org/docs/
# and https://www.varnish-cache.org/trac/wiki/VCLExamples for more examples.

# Marker to tell the VCL compiler that this VCL has been adapted to the
# new 4.0 format.
vcl 4.0;

import std;

# Default backend definition. Set this to point to your content server.
backend default {
	.host = "202.3.200.20";
	#.host = "168.63.21.187";
	.port = "80";
	.first_byte_timeout = 300s;
	.max_connections = 50000;
}

backend queue {
        #.host = "34.241.203.54";
        .host = "10.0.0.56";
        .port = "80";
        .first_byte_timeout = 300s;
        .max_connections = 50000;
}

backend queue_admin {
        .host = "10.0.2.31";
        .port = "15672";
        .first_byte_timeout = 300s;
        .max_connections = 50000;
}

acl purge {
	"localhost";
	"127.0.0.1";
	"::1";
}

sub vcl_recv {

	if (req.method != "GET" &&
		req.method != "HEAD" &&
		req.method != "PUT" &&
		req.method != "POST" &&
		req.method != "TRACE" &&
		req.method != "OPTIONS" &&
		req.method != "PATCH" &&
		req.method != "DELETE" &&
		req.method != "PURGE") {
		/* Non-RFC2616 or CONNECT which is weird. */
		/* Why send the packet upstream, while the visitor is using a non-valid HTTP method? */
		return(synth(500, "Non-valid HTTP method!"));
	}

	if (req.method == "PURGE") {
		if (!client.ip ~ purge) {
			return(synth(405, "Not allowed."));
		}

		if (req.http.X-Purge-Regex) {
			ban("req.http.X-Cache-Type == " + req.http.X-Purge-Regex);
			return(synth(200, "Ban added"));
		} else {
			return (purge);
		}
	}

	if (req.url ~ "^/status") {
                return (synth(800, "OK"));
        }

	if (req.url ~ "^/queue") {
                set req.backend_hint = queue;
                set req.url = "/messages";
		set req.http.X-Cacheable = "NO: RabbitMQ";
		return(pass);
	} else if (req.url ~ "^/rabbitmq") {
                set req.backend_hint = queue_admin;
                set req.url = regsub(req.url, "/rabbitmq/", "/");
		set req.http.X-Cacheable = "NO: RabbitMQ";
		return(pass);
        } else {
                set req.backend_hint = default;
        }


	if (req.url ~ "^/error" || req.url ~ "^/under-construction") {
		# Bypass for all the local resources a local error page
		return(synth(810, "Bypass request"));
	}

	#TODO Temporal hasta apertura de PRO
#	if (!req.http.Cookie ~ "W4EU_DEV") {
#		return(synth(820, "Under construction page"));
#	}

	if (req.http.Upgrade ~ "(?i)websocket") {
		return (pipe);
	}

	set req.http.Cookie = regsuball(req.http.Cookie, "__utm.=[^;]+(; )?", "");
	set req.http.Cookie = regsuball(req.http.Cookie, "_ga=[^;]+(; )?", "");
	set req.http.Cookie = regsuball(req.http.Cookie, "_gat=[^;]+(; )?", "");
	set req.http.Cookie = regsuball(req.http.Cookie, "utmctr=[^;]+(; )?", "");
	set req.http.Cookie = regsuball(req.http.Cookie, "utmcmd.=[^;]+(; )?", "");
	set req.http.Cookie = regsuball(req.http.Cookie, "utmccn.=[^;]+(; )?", "");

	if (req.url ~ "(\?|&)(utm_source|utm_medium|utm_campaign|utm_content|gclid|cx|ie|cof|siteurl)=") {
		set req.url = regsuball(req.url, "&(utm_source|utm_medium|utm_campaign|utm_content|gclid|cx|ie|cof|siteurl)=([A-z0-9_\-\.%25]+)", "");
		set req.url = regsuball(req.url, "\?(utm_source|utm_medium|utm_campaign|utm_content|gclid|cx|ie|cof|siteurl)=([A-z0-9_\-\.%25]+)", "?");
		set req.url = regsub(req.url, "\?&", "?");
		set req.url = regsub(req.url, "\?$", "");
	}

	set req.url = std.querysort(req.url);

	if (req.http.X-Forwarded-For) {
		set req.http.X-Forwarded-For = req.http.X-Forwarded-For + ", " + client.ip;
	} else {
		set req.http.X-Forwarded-For = client.ip;
	}

	if (req.method != "GET" && req.method != "HEAD") {
		set req.http.X-Cacheable = "NO: User interaction";
		return(pass);
	}

	if (req.url ~ "^/manager/") {
		set req.http.X-Cacheable = "NO: Tomcat Manager";
		return(pass);
	}

	if (req.url == "/wifi4eu/") {
		set req.http.X-Cacheable = "NO: Wifi4EU private section";
		return(pass);
	}

	if (std.tolower(req.url) ~ "^[^?]*\.(7z|avi|bmp|bz2|css|csv|doc|docx|vsd|eot|flac|flv|gif|gz|ico|jpeg|jpg|js|less|mka|mkv|mov|mp3|mp4|m4a|mpeg|mpg|wmv|odt|otf|ogg|ogm|opus|pdf|png|ppt|pptx|rar|rtf|svg|svgz|swf|tar|tbz|tgz|ttf|txt|txz|wav|webm|webp|woff|woff2|xls|xlsx|xml|xz|zip|tiff|tif|json)(\?.*)?$") {
		unset req.http.Cookie;
		set req.http.X-Cacheable = "YES: Static resource";
		set req.http.X-Cache-Type = "RESOURCE";
		return(hash);
	}

	if (req.url ~ "/api/" && !(req.url ~ "^/queue" || req.url ~ "^/rabbitmq")) {
		set req.http.X-Cache-Type = "API";
		if (req.url ~ "^/wifi4eu/" && (!req.http.X-API || req.http.X-API == "private")) {
			set req.http.X-Cacheable = "NO: Wifi4EU private API";
			return(pass);
		} else {
			set req.http.X-Cacheable = "YES: Wifi4EU public API";
			return(hash);
		}
	}

	if (req.url ~ "^/wifi4eu/\?ticket=") {
		set req.http.X-Cacheable = "NO: eCAS";
		return(pass);
	}

	if (req.url == "/" || req.url == "/index.jsp") {
		set req.http.X-Cacheable = "YES: Wifi4EU public index";
		set req.http.X-Cache-Type = "PAGE";
		return(hash);
	}

	#Default action
	set req.http.X-Cacheable = "NO: Default";
	set req.http.X-Cache-Type = "PAGE";
	return(pass);
}

sub vcl_synth {
	if (resp.status == 800) {
		set resp.status = 200;
		set resp.http.Content-Type = "text/plain; charset=utf-8";
		return (deliver);
	} else if (resp.status == 810) {
		# Serve a local resources for common error page
		set resp.status = 200;
		synthetic(std.fileread("/etc/varnish" + req.url));
		return(deliver);
	} else if (resp.status == 820) {
		# Serve a local error page
		set resp.status = 200;
		set resp.http.Content-Type = "text/html; charset=utf-8";
		set resp.http.Cache-Control = "no-cache";
		unset resp.http.Expires;
		unset resp.http.Last-Modified;
		unset resp.http.ETag;
		unset resp.http.Pragma;
		synthetic(std.fileread("/etc/varnish/under-construction/under-construction.html"));
		return(deliver);
	} else if (resp.status == 500 || resp.status == 502 || resp.status == 503 || resp.status == 504 || resp.status == 405) {
		# Serve a local error page
		set resp.http.Content-Type = "text/html; charset=utf-8";
		set resp.http.Cache-Control = "no-cache";
		unset resp.http.Expires;
		unset resp.http.Last-Modified;
		unset resp.http.ETag;
		unset resp.http.Pragma;
		synthetic(std.fileread("/etc/varnish/error/error.html"));
		return(deliver);
	}
}

sub vcl_pipe {
	if (req.http.upgrade) {
		set bereq.http.upgrade = req.http.upgrade;
	}

	return (pipe);
}

sub vcl_backend_error {
	if ((beresp.status == 500 || beresp.status == 502 || beresp.status == 503 || beresp.status == 504) && bereq.retries == 3) {
		set beresp.http.Content-Type = "text/html; charset=utf-8";
		synthetic(std.fileread("/etc/varnish/error/error.html"));
		return(deliver);
	} else if ((beresp.status == 500 || beresp.status == 502 || beresp.status == 503 || beresp.status == 504) && bereq.retries < 3) {
		return(retry);
	}
}

sub vcl_backend_response {
	if (beresp.http.Content-Encoding ~ "gzip" ) {
		if (beresp.http.Content-Length == "0") {
			unset beresp.http.Content-Encoding;
		}
	}

	if (beresp.http.X-Powered-By) {
		unset beresp.http.X-Powered-By;
	}

	if (bereq.url ~ "^/manager/") {
		set beresp.http.Cache-Control = "no-cache";
		unset beresp.http.Expires;
		unset beresp.http.Last-Modified;
		unset beresp.http.ETag;
		unset beresp.http.Pragma;
		set beresp.ttl = 120s;
		return (deliver);
	}

	if (bereq.url == "/wifi4eu/") {
		set beresp.http.Cache-Control = "no-cache";
		unset beresp.http.Expires;
		unset beresp.http.Last-Modified;
		unset beresp.http.ETag;
		unset beresp.http.Pragma;
		set beresp.ttl = 120s;
		return (deliver);
	}

	if (bereq.http.X-Cacheable == "NO: RabbitMQ") {
                set beresp.http.Cache-Control = "no-cache";
                unset beresp.http.Expires;
                unset beresp.http.Last-Modified;
                unset beresp.http.ETag;
                unset beresp.http.Pragma;
                set beresp.ttl = 0s;
                return(deliver);
        }

	if (beresp.status == 200 || beresp.status == 304) {
		if (std.tolower(bereq.url) ~ "^[^?]*\.(7z|avi|bmp|bz2|css|csv|doc|docx|vsd|eot|flac|flv|gif|gz|ico|jpeg|jpg|js|less|mka|mkv|mov|mp3|mp4|m4a|mpeg|mpg|wmv|odt|otf|ogg|ogm|opus|pdf|png|ppt|pptx|rar|rtf|svg|svgz|swf|tar|tbz|tgz|ttf|txt|txz|wav|webm|webp|woff|woff2|xls|xlsx|xml|xz|zip|tiff|tif|json)(\?.*)?$") {
			unset beresp.http.set-cookie;
			unset beresp.http.cookie;
			set beresp.http.Cache-Control = "max-age=315360000, public";
			set beresp.http.Expires = "" + (now + std.duration("10y", 60s));
			set beresp.ttl = 10y;
			return(deliver);
		}

		if (bereq.method != "GET" && bereq.method != "HEAD") {
			set beresp.http.Cache-Control = "no-cache";
			unset beresp.http.Expires;
			unset beresp.http.Last-Modified;
			unset beresp.http.ETag;
			unset beresp.http.Pragma;
			set beresp.ttl = 0s;
			return(deliver);
		}

		if (bereq.url ~ "/api/") {
			if (bereq.url ~ "^/wifi4eu/" && (!bereq.http.X-API || bereq.http.X-API == "private")) {
				set beresp.http.Cache-Control = "no-cache";
				unset beresp.http.Expires;
				unset beresp.http.Last-Modified;
				unset beresp.http.ETag;
				unset beresp.http.Pragma;
				set beresp.ttl = 0s;
				return(deliver);
			} else {
				unset beresp.http.set-cookie;
                                unset beresp.http.cookie;
				set beresp.http.Cache-Control = "max-age=3600, public";
				set beresp.http.Expires = "" + (now + std.duration("1h", 60s));
				unset beresp.http.ETag;
				set beresp.ttl = 1h;
				set beresp.grace = 1h;
				return(deliver);
			}
		}

		if (beresp.http.Set-Cookie) {
			set beresp.http.Cache-Control = "no-cache";
			unset beresp.http.Expires;
			unset beresp.http.Last-Modified;
			unset beresp.http.ETag;
			unset beresp.http.Pragma;
			set beresp.ttl = 120s;
			return (deliver);
		}

		set beresp.http.Cache-Control = "max-age=86400, public";
		set beresp.http.Expires = "" + (now + std.duration("1d", 60s));
		unset beresp.http.ETag;
		set beresp.ttl = 1d;
		set beresp.grace = 1d;
	} else if (beresp.status == 404) {
		# Cache 404 responses
		set beresp.http.Cache-Control = "max-age=1200, public";
		set beresp.http.Expires = "" + (now + std.duration("20m", 1m));
		set beresp.ttl = 20m;
		set beresp.grace = 20m;
	} else if (beresp.status == 303 || beresp.status == 307) {
		# Cache 303 or 307 - See other
		set beresp.http.Cache-Control = "no-cache";
		unset beresp.http.Expires;
		unset beresp.http.Last-Modified;
		unset beresp.http.ETag;
		unset beresp.http.Pragma;
		set beresp.ttl = 0s;
	} else if (beresp.status == 301 || beresp.status == 302) {
		# Cache 301 or 302 responses
		set beresp.http.Cache-Control = "no-cache";
		unset beresp.http.Expires;
		unset beresp.http.Last-Modified;
		unset beresp.http.ETag;
		unset beresp.http.Pragma;
		set beresp.ttl = 0s;
	} else if ((beresp.status == 500 || beresp.status == 502 || beresp.status == 503 || beresp.status == 504) && bereq.retries < 3) {
		# Cache 50X responses
		#return (abandon);
		return(retry);
	} else {
		# Cache XXX responses
		set beresp.http.Cache-Control = "max-age=86400, public";
		set beresp.http.Expires = "" + (now + std.duration("1d", 1m));
		set beresp.ttl = 1d;
		set beresp.grace = 1d;
	}

	return(deliver);
}

sub vcl_hash {
	if (req.http.X-Cacheable ~ "YES") {
		if (req.method != "GET" && req.method != "HEAD" && req.http.Cookie ~ "JSESSIONID") {
			hash_data(req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" ));
			set req.http.X-Calc-hash = req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" );
			return(lookup);
		}

		if(req.url ~ "^/wifi4eu/\?ticket=" && req.http.Cookie ~ "JSESSIONID") {
			hash_data(req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" ));
			set req.http.X-Calc-hash = req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" );
			return(lookup);
		}

		if(req.url == "/wifi4eu/" && req.http.Cookie ~ "JSESSIONID") {
			hash_data(req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" ));
			set req.http.X-Calc-hash = req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url + "-" + regsub(req.http.Cookie, ".*JSESSIONID=([^;]+);.*", "\1" );
			return(lookup);
		}

		hash_data(req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url);
		set req.http.X-Calc-hash = req.http.host + "-" + req.http.X-Cache-Type + "-" + req.url;
	}
}

sub vcl_deliver {
	if (obj.hits > 0) {
		set resp.http.X-Cache = "HIT";
	} else {
		set resp.http.X-Cache = "MISS";
	}
	set resp.http.X-Cache-Hits = obj.hits;

	unset resp.http.X-Varnish;
	unset resp.http.Via;
}