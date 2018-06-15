def call(String scmUrl, String projectName, String repoName, String credentialsId, String branch='master', String scmClass = 'GitSCM') {

  def scm = [ 
    $class            : "${scmClass}",
    userRemoteConfigs : [[url: scmUrl + projectName + "/" + repoName + ".git", credentialsId: "${credentialsId}"]],
    branches          : [[name: "${branch}"]]
  ]
  
  return scm
}
