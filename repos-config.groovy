return [
    [
        name: 'product_backend',
        paramName: 'IE_GLOBAL_TAG',
        defaultTag: 'develop',
        buildCmd: "mvn -U -P '!tag' clean install",
        description: 'Build backend with Maven'
    ],
    [
        name: 'product_frontend',
        paramName: 'IE_DEPS_TAG',
        defaultTag: 'develop',
        buildCmd: "docker build -t product_frontend:!tag .",
        description: 'Build Docker image for frontend'
    ],
]
