using System;
using System.Net;
using System.IO;

/*
The project is  azure-edcc-cs-2
    https://portal.azure.com/ >> Instancias de Function App >> azure-edcc-cs-2 >> TimerTriggerCSharp1
*/

namespace azureProject
{
    class Program
    {
        //In AZure you MUST change 'Main' by 'Run'
        static void Main(string[] args)
        {
            Console.WriteLine($"C# Timer trigger function executed at: {DateTime.Now}");

            string BASE_URL     = "http://wifi4eu.everisdigitalchannels.com:8080/wifi4eu-edcc";
            string URL_GET_TOKEN = BASE_URL + "/oauth/token?grant_type=password&username=wififoreu_public_user&password=q27Dz38WESBeYE9BX6PrySfH";
            string URL_CALL_EDCC = BASE_URL + "/edcc/helpdesk/?access_token=";
            string AUTH = "Basic bXktd2lmaTRldS1zZWN1cmVkLXRydXN0ZWQtY2xpZW50OkBwflJ7LmJycjItP3tuIT0/SH5XVXhSPU0oTHNRRmJEazt1OmFmIjZCYnJiRGA+M0xMcVI8OHI6TStzYStDZCl3WmVLQEtnTXhHPy9SU1ohZTlbcW5HTS8nPSNLLURkQS4zVURue0JjNChkWVdWfTVIYWgiJCNDIT9GLn5QSGA4";

            string tokeResponse = send(URL_GET_TOKEN, "POST", AUTH);
            string accessToken = getAccessToken(tokeResponse);
            string response = send(URL_CALL_EDCC+accessToken, "GET", AUTH);

            Console.WriteLine(response);
        }
        
        static public string getAccessToken(string response)
        {
            //This line should be changed by a jSon parser
            Console.WriteLine(response.Substring(17, 36));
            return response.Substring(17, 36);
        }

        static public string send(string uri, string method, string authorization)
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(uri);
            request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;
            request.Method = method;
            request.Accept = "application/json";
            if(authorization != null) {
                request.Headers.Add("Authorization", authorization);
            }

            using(HttpWebResponse response = (HttpWebResponse)request.GetResponse())
            using(Stream stream = response.GetResponseStream())
            using(StreamReader reader = new StreamReader(stream))
            {
                return reader.ReadToEnd();
            }
        }

    }
}
