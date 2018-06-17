# ADOP Pluggable SCM Jenkinsfile Library

This pipeline shared library provides a mechanism to create and consume a generic SCM provider object within Jenkins Pipelines (either inline or via Jenkinsfiles).

# Using the library

In order to consume the library in your Jenkins pipeline, ensure you have first followed [these instructions](https://jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries) to install the library in your Jenkins instance.

At the top of your pipeline script/Jenkinsfile, you can then import the library as such:
```
@Library('adop-pluggable-scm-jenkinsfile') _
```
Instead of annotating an unnecessary import statement, the symbol _ is annotated, according to the [annotation pattern](https://jenkins.io/doc/book/pipeline/shared-libraries/#loading-libraries-dynamically).

To consume the scm object, insert the following method call in your Pipeline script:
```
checkout scmGet(scmUrl, projectName, repoName, credentialsId, branch, additionalMapExtensions, scmClass)
```
where

  * scmUrl is the base URL of the SCM provider you want to use with a trailing slash e.g. https://github.com/
  * projectName is the name of the repository to checkout
  * repoName is the name of the repository to checkout
  * credentialsId is the name of the credential in the Jenkins credential manager to use
  * branch is the name of the branch to checkout on ref updates, defaults to master
  * additionalMapExtensions is an additional arrayList of scm extensions which will be appended to the returned scm object, defaults to empty
  * scmClass is the name of the parent SCM class to implement, defaults to Git

# License
Please view [license information](LICENSE.md) for the software contained on this image.

## Documentation
Documentation will be captured within this README.md and this repository's [Wiki](https://github.com/Accenture/adop-pluggable-scm-jenkinsfile/wiki).

## Issues
If you have any problems with or questions about this library, please contact us through a [GitHub issue](https://github.com/Accenture/adop-pluggable-scm-jenkinsfile/issues).

## Contribute
You are invited to contribute new features, fixes, or updates, large or small; we are always thrilled to receive pull requests, and do our best to process them as fast as we can.

Before you start to code, we recommend discussing your plans through a [GitHub issue](https://github.com/Accenture/adop-pluggable-scm-jenkinsfile/issues), especially for more ambitious contributions. This gives other contributors a chance to point you in the right direction, give you feedback on your design, and help you find out if someone else is working on the same thing.