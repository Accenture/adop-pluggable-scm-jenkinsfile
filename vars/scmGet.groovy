def call(String scmClass = 'GitSCM', String scmUrl, String projectName, String repoName, String credentialsId, String branch='master') {

  def scm = [ 
    $class            : "${scmClass}",
    userRemoteConfigs : [[url: scmUrl + projectName + "/" + repoName + ".git", credentialsId: "${credentialsId}"]],
    branches          : [[name: "${branch}"]]
  ]
  
  return scm
}