def call(String scmUrl, String projectName, String repoName, String credentialsId, String branch='master', def additionalMapExtensions = [], String scmClass = 'GitSCM') {

  def scm = [ 
    $class            : "${scmClass}",
    userRemoteConfigs : [[url: scmUrl + projectName + "/" + repoName + ".git", credentialsId: "${credentialsId}"]],
    branches          : [[name: "${branch}"]]
  ]
  
  if (additionalMapExtensions) {
    scm << additionalMapExtensions
  }

  return scm

}