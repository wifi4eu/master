# A dummy plugin for Barge to set hostname and network correctly at the very first `vagrant up`
module VagrantPlugins
  module GuestLinux
    class Plugin < Vagrant.plugin("2")
      guest_capability("linux", "change_host_name") { Cap::ChangeHostName }
      guest_capability("linux", "configure_networks") { Cap::ConfigureNetworks }
    end
  end
end

# script to move configuration files and libraries to Tomcat container
$script_tomcatConfig = <<-SCRIPT
docker cp /home/bargee/dev/lib/mssql-jdbc-6.4.0.jre8.jar tomcat:/usr/local/tomcat/lib
docker cp /home/bargee/dev/lib/jtds-1.3.1.jar tomcat:/usr/local/tomcat/lib
docker cp /home/bargee/dev/lib/ecas-tomcat-8.0-4.26.0.jar tomcat:/usr/local/tomcat/lib
docker cp /home/bargee/dev/lib/org tomcat:/usr/local/tomcat/lib
docker cp /home/bargee/dev/conf/context.xml tomcat:/usr/local/tomcat/conf
docker cp /home/bargee/dev/conf/tomcat-users.xml tomcat:/usr/local/tomcat/conf
docker restart tomcat
SCRIPT

Vagrant.configure("2") do |config|

  config.vm.define "barge"

  config.vm.box = "ailispaw/barge"

  config.vm.synced_folder "LocalDevelopment/tomcat/webapps", "/home/bargee/dev/webapps", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]
  config.vm.synced_folder "LocalDevelopment/tomcat/logs", "/home/bargee/dev/logs", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]
  config.vm.synced_folder "LocalDevelopment/tomcat/conf", "/home/bargee/dev/conf", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]
  config.vm.synced_folder "LocalDevelopment/tomcat/lib", "/home/bargee/dev/lib", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]

  config.vm.synced_folder "LocalDevelopment/sql", "/home/bargee/dev/sql", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]

  config.vm.provision "sqlserver", type: "docker" do |d|
    d.pull_images "mcr.microsoft.com/mssql/server:2017-latest"
    d.run "sqlserver",
      image: "mcr.microsoft.com/mssql/server:2017-latest",
      args: "-e \"ACCEPT_EULA=Y\" -e \"SA_PASSWORD=SQLserver1\" -p 1433:1433 --name sql1 --restart always -v /home/bargee/dev/sql:/tmp/sql"
  end

  config.vm.provision "blob", type: "docker" do |d|
      d.pull_images "arafato/azurite"
      d.run "blob",
        image: "arafato/azurite",
        args: "-e executable=blob -p 10000:10000 --name blob --restart always"
  end

  config.vm.provision "tomcat", type: "docker" do |d|
      d.pull_images "tomcat:8.5"
      d.run "tomcat",
          image: "tomcat:8.5",
          cmd:"catalina.sh jpda run",
          args:"--link sql1:sqlserver --link blob:blob -e JPDA_TRANSPORT=dt_socket -e JPDA_ADDRESS=8000 -p 8080:8080 -p 8000:8000 -v /home/bargee/dev/webapps:/usr/local/tomcat/webapps -v /home/bargee/dev/logs:/usr/local/tomcat/logs --name tomcat --restart always"
  end

  # configure tomcat with jdbc driver and ECAS client
  config.vm.provision "tomcat_config", type: "shell", inline: $script_tomcatConfig

  # load wifi4eu schema in db
  config.vm.provision "sqlserver_config", type: "shell", inline: $script_dbLoad

  # local ip setting for the vagrant box
  config.vm.network "private_network", ip: "172.30.10.10"

  # tomcat port forwarding
  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.network "forwarded_port", guest: 8000, host: 8000

  #sql server port forwarding
  config.vm.network "forwarded_port", guest: 1433, host: 1433

  #blob server port forwarding
  config.vm.network "forwarded_port", guest: 10000, host: 10000

  config.vm.provider "virtualbox" do |vb|
   # Customize the amount of memory on the VM:
    vb.memory = "4096"
  end

end