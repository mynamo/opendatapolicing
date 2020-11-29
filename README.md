
# Installation

The installation of the project for both development and production in containers is completely automated with Ansible. 
Begin by installing both the python3 packages for the latest version of Python and Pip Python package installer. 

```bash
sudo yum install -y python3 python3-pip
```

With the latest version of Python, you can install the lastest version of Ansible. 

```bash
sudo pip3 install ansible
```

Install the required Ansible dependencies for setting up a PostgreSQL database. 

```bash
sudo pip3 install psycopg2-binary
```

Install the Ansible dependencies to deploy the application to the OpenShift cloud environment. 

```bash
sudo pip3 install openshift
```

## Enable SSH

Also, make sure your machine allows ssh. If you are on a linux machine (Fedora):

```bash
sudo yum install -y openssh-server
sudo systemctl start sshd.service
sudo systemctl enable sshd.service
ssh localhost (say yes to creating the fingerprint)
exit
```

## Ansible training. 

For training on ansible and automation, I recommend the following Red Hat course. 
By completing the course and taking the exam, you can be a Red Hat Certified Specialist in Ansible Automation. 

https://www.redhat.com/en/services/training/do407-automation-ansible-i

## Development installation of opendatapolicing. 

### Create an ansible inventory for development. 

You will want to create your own directory to store your ansible inventories for both development and production in the cloud. 

Create a directory for your ansible scripts. 

```bash
sudo install -d -o $USER -g $USER /usr/local/src/opendatapolicing-ansible
```

Create a directory for your development inventory. 

```bash
install -d /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME
```

Create a hosts file for your development inventory. 

```bash
echo 'localhost' > /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/hosts
```

### Create an ansible vault for the application secrets. 

Create an encrypted ansible vault with a password for the host secrets for your development inventory. 

```bash
ansible-vault edit /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/host_vars/$HOSTNAME/vault
```

The contents of the vault will contain the secrets needed to override any default values you want to change in the opendatapolicing defaults defined here. 

https://github.com/computate/computate/blob/master/ansible/roles/opendatapolicing/defaults/main.yml

There are descriptions for each of the fields. 
There are several sections of fields, including: 

* opendatapolicing system defaults
* Ansible defaults
* Zookeeper defaults
* Solr defaults
* PostgreSQL defaults
* computate-medical global defaults
* opendatapolicing US English defaults
* SMTP defaults
* OpenID Connect auth server defaults
* SSL/TLS defaults

### Clone the computate project to run the ansible scripts. 

Create a directory for the computate project containing the ansible scripts to run. 

```bash
sudo install -d -o $USER -g $USER /usr/local/src/computate
```

Clone the computate project. 

```bash
git clone https://github.com/computate-org/computate.git /usr/local/src/computate
```

Change to the computate ansible directory. 

```bash
cd /usr/local/src/computate/ansible
```

#### Run the playbook to install a PostgreSQL server on your development computer. 

```bash
ansible-playbook computate_postgres.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/hosts --vault-id @prompt
```

#### Run the playbook to install a Zookeeper cluster manager on your development computer. 

```bash
ansible-playbook computate_zookeeper.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/hosts --vault-id @prompt
```

#### Run the playbook to install a Solr search engine on your development computer. 

```bash
ansible-playbook computate_zookeeper.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/hosts --vault-id @prompt
```

#### Run the playbook to install the opendatapolicing project for development. 

```bash
ansible-playbook opendatapolicing.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-$HOSTNAME/hosts --vault-id @prompt
```

If you are on an older operating system with an older version of ansible, you may run into the following error: 

```
ERROR! no action detected in task. This often indicates a misspelled module name, or incorrect module path.

The error appears to have been in '/usr/local/src/computate/ansible/roles/opendatapolicing/tasks/main.yml': line 62, column 3, but may                                                                                                   
be elsewhere in the file depending on the exact syntax problem.

The offending line appears to be:

  become_user: "{{POSTGRES_BECOME_USER}}"
- name: Grant enUS user access to database
  ^ here
```

This means that the older version of ansible probably doesn't support the postgresql_pg_hba module and you will have to remove that task before running the ansible playbook successfully. 
You will need to configure the PostgreSQL hba configuration yourself in this situation. 

# Start the development project in English. 

## Maven build the opendatapolicing project. 

```bash
cd /usr/local/src/opendatapolicing
mvn clean insta..
```

## Make sure the Eclipse Marketplace and Git integration are installed. 

Help -> Install

Work with: Oxygen - http://download.eclipse.org/releases/oxygen

Or whatever your eclipse release is. 

* General Purpose Tools -> Marketplace Client
* Collaboration -> Git integration for Eclipse

## Install the Eclipse maven plugin. 

Install from Marketplace "Maven Integration for Eclipse"

## Import the opendatapolicing project into Eclipse. 

File -> Import... -> Maven -> Existing Maven Projects

Click [ Next > ]

Root Directory: /usr/local/src/opendatapolicing

Click [ Finish ]

## Eclipse Debug Configuration. 

Main Project: opendatapolicing

Main class: com.opendatapolicing.enUS.vertx.AppVertx

Environment Variables: 

* configPath: /usr/local/src/opendatapolicing/config/opendatapolicing-enUS.config
* zookeeperHostName: localhost
* zookeeperPort: 2181

# Deploy opendatapolicing in US English to OpenShift. 

For training on OpenShift and modern cloud application development, I recommend the following Red Hat course. 
By completing the course and taking the exam, you can be a Red Hat Certified Specialist in OpenShift Application Development. 

https://www.redhat.com/en/services/training/do288-red-hat-openshift-development-i-containerizing-applications

### Create an ansible inventory for production. 

You will want to create your own directory to store your ansible inventories for production in the cloud. 

Create a directory for your ansible scripts. 

```bash
sudo install -d -o $USER -g $USER /usr/local/src/opendatapolicing-ansible
```

Create a directory for your production inventory. 

```bash
install -d /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift
```

Create a hosts file for your production inventory. 

```bash
echo 'localhost' > /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts
```

### Create an ansible vault for the application secrets. 

Create an encrypted ansible vault with a password for the host secrets for your production inventory. 

```bash
ansible-vault edit /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/host_vars/localhost/vault
```

The contents of the vault will contain the secrets needed to override any default values you want to change in the opendatapolicing defaults defined here. 

https://github.com/computate/computate/blob/master/ansible/roles/opendatapolicing_openshift_enUS/defaults/main.yml

There are descriptions for each of the fields. 
There are several sections of fields, including: 

* Ansible defaults
* Zookeeper defaults
* Solr defaults
* PostgreSQL defaults
* computate-medical global defaults
* opendatapolicing US English defaults
* SMTP defaults
* SSL/TLS defaults
* OpenID Connect auth server defaults

Change to the computate ansible directory. 

```bash
cd /usr/local/src/computate/ansible
```

Run the playbook to install a PostgreSQL server in your OpenShift environment. 

```bash
ansible-playbook postgres_openshift.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts --vault-id @prompt
```

Run the playbook to install a Zookeeper cluster manager in your OpenShift environment. 

```bash
ansible-playbook computate_zookeeper_openshift.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts --vault-id @prompt
```

Run the playbook to install a Solr search engine in your OpenShift environment. 

```bash
ansible-playbook computate_zookeeper_openshift.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts --vault-id @prompt
```

Run the playbook to install a Red Hat SSO server in your OpenShift environment. 

```bash
ansible-playbook redhat_sso_openshift.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts --vault-id @prompt
```

Run the playbook to install the opendatapolicing project in your OpenShift environment. 

```bash
ansible-playbook opendatapolicing_openshift.yml -i /usr/local/src/opendatapolicing-ansible/inventories/$USER-openshift/hosts --vault-id @prompt
```


