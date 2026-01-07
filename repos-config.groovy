// repos-config.groovy
return [
    [
        name: 'product-backend',
        paramName: 'IE_GLOBAL_TAG',
        defaultTag: 'develop',
        buildCmd: "mvn -U -P '!tag' clean install",
        description: 'ie-global branch/tag'
    ],
    [
        name: 'product-frontend',
        paramName: 'IE_DEPS_TAG',
        defaultTag: 'develop',
        buildCmd: "mvn -U -P '!tag' clean install",
        description: 'ie-deps branch/tag'
    ],
    [
        name: 'ie-core',
        paramName: 'IE_CORE_TAG',
        defaultTag: 'develop',
        buildCmd: "mvn clean package -DskipTests",
        description: 'ie-core branch/tag'
    ],
    // Add all 16 repos...
]