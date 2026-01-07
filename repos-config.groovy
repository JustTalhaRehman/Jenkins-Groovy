// repos-config.groovy
return [
    [
        name: 'product_backend',
        paramName: 'IE_GLOBAL_TAG',
        defaultTag: 'develop',
        buildCmd: "docker build -t product_frontend: .",
        description: 'ie-global branch/tag'
    ],
    [
        name: 'product_frontend',
        paramName: 'IE_DEPS_TAG',
        defaultTag: 'develop',
        buildCmd: "docker build -t product_frontend: .",
        description: 'ie-deps branch/tag'
    ],

    // Add all 16 repos...
]
