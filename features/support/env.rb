require "capybara"
require "capybara/cucumber"
require "selenium-webdriver"

CONFIG = YAML.load_file(File.join(Dir.pwd, "features/support/config/#{ENV["ENV_TYPE"]}.yaml"))

Capybara.configure do |config|
    config.default_driver =:selenium
    config.app_host = CONFIG["url"]
end