pipeline{
   agent any
   environment{
   
     scannerHome= tool name : 'SonarQubeScanner'
	 project_id= 'testjenkinsproject'
	 cluster_name='testjenkinsproject'
	 location='us-central1-c'
	 
   
   }
   tools{
   
   maven "Maven3"
   
   
   }
   stages{
      stage('Checkout Code'){
			steps{
			
			git branch:feature,credentialsId:'github',url:'https://github.com/HimanshiVerma05/BiannualDevops.git'
			}
	  
	  
	  }
	  stage('Build Code'){
			steps{
			
			bat 'mvn clean package'
			}
	  
	  
	  }
	   stage('Unit Testing'){
			steps{
			
			bat 'mvn test'
			}
	  
	  
	  }
	  stage('SonarQube Analysis'){
			steps{
			
			withSonarQubeEnv('Test_Sonar'){
			  bat "${scannerHome}/bin/sonar-scanner\
			  -Dsonar.projectKey=sonar-himanshiverma \
			  -Dsonar.projectName=sonar-himanshiverma \
			  -Dsonar.host.url=http://localhost:9000 \
			  -Dsonar.java.binaries=target/classes"
			  
			
			}
			}
	  
	  
	  }
	  stage('Docker Image Build'){
			steps{
			
			bat "docker build -t i-himanshiverma-feature:latest --no-cache -f Dockerfile ."
			}
	  
	  
	  }
	   stage('Docker Image Push to docker hub '){
			steps{
			    
				script{
				try{
				
				 bat "docker stop c-himanshiverma-feature"
				 
				 bat "docker container rm c-himanshiverma-feature"
				}
				catch(Exception ex){
				
				
				}
				
				}
				
				bat "docker tag i-himanshiverma-feature:latest himanshiverma05/i-himanshiverma-feature:latest"
				
				withDockerRegistry([credentialsId:'DockerHub',url:""]){
				    
					bat "docker push himanshiverma05/i-himanshiverma-feature:latest"
				
				}
		
			}
	  
	  
	  }
	  stage('Deployment'){
	  
			parallel{
				stage('Docker Deployment'){
				
				steps{
				
				bat "docker run --name c-himanshiverma-feature -d -p 7400:8100 himanshiverma05/i-himanshiverma-feature:latest"
				
				}
				}
				stage('Kubernetes deployment'){
				steps{
				
				bat "kubectl config use-context gke_${project_id}_${location}_${cluster_name}"
				bat "kubectl apply -f ${WORKSPACE}\\deployment"
				
				script{
				try{
				
				bat "gcloud compute firewall-rules create firewallforfeature --aloow tcp:7400"
				
				}
				catch(Exception ex){
				
				}
				
				}
				
				}
				
				}
				
			}
	  
	  }
   
   
   }

































}