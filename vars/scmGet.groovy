/**
* Constructs and returns an scm LinkedHashMap object which can be checked out in a Jenkins pipeline stage
*
* @param scmUrl - base URL of the SCM provider you want to use with a trailing slash e.g. https://github.com/
* @param projectName - name of the project/namespace in your SCM provider
* @param repoName - name of the repository to checkout
* @param credentialsId - id of the credential in the Jenkins credential manager to use
* @param branch - name of the branch to checkout on ref updates, defaults to master
* @param additionalMapExtensions - additional arrayList scm extensions which will be appended to the returned scm object, defaults to empty
* @param scmClass - name of the parent SCM class to implement, defaults to Git
* @return an scm LinkedHashMap object which can be checked out in a Jenkins pipeline stage
*/
def call(String scmUrl, String projectName, String repoName, String credentialsId, String branch='master', def additionalMapExtensions = [], String scmClass = 'GitSCM') {

  def scm = [ 
    $class            : "${scmClass}",
    userRemoteConfigs : [[url: scmUrl + projectName + "/" + repoName + ".git", credentialsId: "${credentialsId}"]],
    branches          : [[name: "${branch}"]]
  ]
  
  // Only merge with main Linked Hashmap if not empty or null
  if (additionalMapExtensions) {
    scm << additionalMapExtensions
  }

  return scm

}