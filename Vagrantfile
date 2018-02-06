Vagrant.configure("2") do |config|
  config.vm.box = "wifi4eu"
  config.vm.hostname = "wifi4eu"
  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.synced_folder ".", "/vagrant"
  config.vm.provider "virtualbox" do |vb|
      vb.name = "wifi4eu"
      vb.gui = false
      vb.memory = "4096"
  end
end