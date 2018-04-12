const karmaConfig = require('@eui/tools').karmaConfig;

module.exports = function (config) {
    config.set(
        karmaConfig.get(config)
    );
}
