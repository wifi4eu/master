# A dummy plugin for Barge to set hostname and network correctly at the very first `vagrant up`
module VagrantPlugins
  module GuestLinux
    class Plugin < Vagrant.plugin("2")
      guest_capability("linux", "change_host_name") { Cap::ChangeHostName }
      guest_capability("linux", "configure_networks") { Cap::ConfigureNetworks }
    end
  end
end

# script to set http proxy to allow docker provider to download images, you don't need this if your outside the EC network
$script_setproxy = <<-SCRIPT
sudo su
echo 'export http_proxy="http://manalmi:@147.67.117.13:8012/"' >> /etc/default/docker
echo 'export https_proxy="https://manalmi:@147.67.117.13:8012/"' >> /etc/default/docker
/etc/init.d/docker restart
SCRIPT

Vagrant.configure("2") do |config|

  config.vm.define "barge"

  config.vm.box = "ailispaw/barge"

  config.vm.synced_folder "LocalDevelopmemt/tomcat/webapps", "/home/bargee/dev/webapps", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]
  config.vm.synced_folder "LocalDevelopmemt/tomcat/logs", "/home/bargee/dev/logs", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]
  config.vm.synced_folder "LocalDevelopmemt/tomcat/conf", "/home/bargee/dev/conf", :create => true, :owner => "bargee", :group => "bargees", :mount_options  => ["dmode=755","fmode=755"]

  # comment this out if you are outside the EC network
  config.vm.provision "shell", inline: $script_setproxy

  config.vm.provision :docker do |d|
    d.pull_images "microsoft/mssql-server-linux:2017-latest"
    d.run "sqlserver",
      image: "microsoft/mssql-server-linux:2017-latest",
      args: "-e \"ACCEPT_EULA=Y\" -e \"SA_PASSWORD=SQLserver1\" -p 1433:1433 --name sql1 --restart always"

    d.pull_images "tomcat:8.5"
    d.run "tomcat",
        image: "tomcat:8.5",
        args:"-p 8880:8080 -v /home/bargee/dev/webapps:/usr/local/tomcat/webapps -v /home/bargee/dev/logs:/usr/local/tomcat/logs --name tomcat --restart always"
  end

  config.vm.network "private_network", ip: "172.30.10.10"

  config.vm.network "forwarded_port", guest: 8880, host: 8888
  config.vm.network "forwarded_port", guest: 1433, host: 1433

  config.vm.provider "virtualbox" do |vb|
   # Customize the amount of memory on the VM:
    vb.memory = "4096"
  end

end
