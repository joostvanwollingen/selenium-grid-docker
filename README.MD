# Selenium-Grid-Docker sample project
Sample project that shows how to use a Selenium Hub/Selenium nodes running in Docker from your tests

## Setup
- Forward ports from your docker-vm
   - 5900 for VNC
   - 4444 for Selenium Hub

- Start the Selenium hub and node-firefox-debug
    ``` bash
    $  docker-compose up --force-recreate
    ```
    <sub>--force-recreate as a work around for https://github.com/SeleniumHQ/docker-selenium/issues/91</sub>

OR:

- Start the hub and nodes you want separately

    ``` bash
    $ docker run --rm -p 4444:4444 --name selenium-hub selenium/hub
    $ docker run --rm -P -p 5900:5900 --link selenium-hub:hub selenium/node-firefox-debug
    ```

    <sub>Visit https://github.com/SeleniumHQ/docker-selenium for more node containers</sub>

# Watching test execution with VNC
Connect using a VNC viewer to node-firefox-debug with port 5900, password: secret (no username)