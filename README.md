# Jenkins-Groovy
Jenkins Multi-Repository Sequential Build Pipeline

This Jenkins pipeline clones and builds multiple GitHub repositories sequentially using a single reusable pipeline. Repository details are defined in a separate configuration file (repos-config.groovy) for easy maintenance and scalability.

Files Overview
Jenkinsfile
repos-config.groovy


Jenkinsfile: Orchestrates the build pipeline

repos-config.groovy: Contains all repository info and build commands

Repository Configuration (repos-config.groovy)

Defines repositories as a list of maps:

return [
    [
        name: 'product-backend',
        defaultTag: 'develop',
        buildCmd: "mvn -U -P '!tag' clean install"
    ],
    [
        name: 'product-frontend',
        defaultTag: 'develop',
        buildCmd: "mvn -U -P '!tag' clean install"
    ]
]


!tag → Placeholder replaced with branch/tag at runtime

defaultTag → Branch or tag to build

buildCmd → Command to execute the build

How Files Communicate
def reposConfig = load 'repos-config.groovy'


Jenkins loads the config file

Returns a list of repositories

Pipeline loops over this list for sequential processing

Pipeline Stages
1️⃣ Load Configuration
stage('Load Configuration')


Loads repos-config.groovy

Confirms how many repositories will be processed

2️⃣ Clone & Build Repositories (Sequential)
stage('Clone & Build Repositories (Sequential)')


For each repository:

a) Dynamic Stage
stage("Build ${repo.name}")


Separate stage per repo for clarity in Jenkins UI

b) Error Handling
catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE')


Pipeline continues even if a repository fails

c) Workspace Isolation
dir("workspace/${repo.name}") { deleteDir() }


Each repo gets its own workspace

d) Secure Git Clone
withCredentials([...]) {
    sh "git clone --branch ${branch} https://${GIT_USER}:${GIT_PAT}@${params.GIT_BASE_URL}/${repo.name}.git ."
}


Uses Jenkins credentials securely

e) Build Execution
def buildCommand = repo.buildCmd.replace('!tag', branch)
sh buildCommand


Executes dynamic build command per repository

3️⃣ Post Action
post {
    always {
        echo "Pipeline completed (failures allowed, sequential execution)"
    }
}


Runs after pipeline completes

Confirms pipeline finished successfully/unstable
