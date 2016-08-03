# openshift-demo
This is a Java Maven-based project which can produce a Docker image and includes an OpenShift template for deployment on
the OpenShift 3.x environment.  Currently, you can sign up for a free developer preview of [OpenShift](https://www.openshift.com/devpreview/register.html).

This demo was created because I had some initial minor difficulty getting a Tomcat application running in a Docker
container on OpenShift.  The issue was running as root.  Because this is not allowed by default on the public
OpenShift service, there was a file permission issue with the Docker Tomcat container.  The solution used
in this project is changing the file permissions in the Docker file found in src/main/docker.

To create the Docker image
```
mvn package docker:build
```

To run the container on Linux or MacOS
```
src/main/run.sh
```

Then visit [http://localhost:18080](http://localhost:18080) to see the application running in your browser.

To deploy the image to the Docker repository, you will need to modify the src/main/docker/push.sh script to 
use your own account name (i.e. change the two instances of "carljmosca" to your own name).

To run the application on OpenShift, the src//main/openshift/create.sh script can be used.  Once you have created
an OpenShift account and logged in, this script can be used to create project and template.  
NOTE: The src/main/openshift/openshift-demo-template.json includes a reference to the Docker hosted image
and the repository should be changed from "carljmosca" to your own.

After running the script which creates the project and the template, the OpenShift web interface
can be used to add deploy the application.  Click on the "Add to Project" button and then select the 
openshift-tomcat-demo from Instant Apps.
