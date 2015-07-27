- Add Server
	- Click on the servers tab.
	- Click the link to add server.
	- Select apache and then server.
	- Open the dialog and select the install.
	- Click ok.
	
- Make sure postgres is ready
	sudo -u postgres psql postgres
	\password postgres
	react
	react
	sudo -u postgres createdb reactdbserver
	- Open pgadmin and connect to server.

- Change Server Settings
	- In server.xml find <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
	- Change port to 8081

- Start up
	- Add the project to the server.
	- http://localhost:8080/{project.name}/{controller.method}

- Set up Git
	- Go to bitbucket.
	- Click 'Create' and fill in info.
	- Click the 'I have an existing project' and copy the code and execute it in terminal.
	
- Set up to send datas via postman
	- set to post
	- click x-www-form-urlencoded on the presets.
	- set the values in the fields.