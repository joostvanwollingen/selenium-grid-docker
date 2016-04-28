# Forward ports from your docker-vm:
5900 for VNC
4444 for Selenium Hub

# Start the hub
docker run --rm -p 4444:4444 --name selenium-hub selenium/hub

# Start the nodes
docker run --rm -P -p 5900:5900 --link selenium-hub:hub selenium/node-firefox-debug

or:
docker run -d -p 4444:4444 --name selenium-hub selenium/hub
docker run -d -P --link selenium-hub:hub selenium/node-firefox
docker run -d -P --link selenium-hub:hub selenium/node-chrome

# Watching test execution with VNC
Connect using VNC to node-firefox-debug with port 5900, password: secret (no username)

