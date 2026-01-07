return [
    [
        name: 'product_backend',
        defaultTag: 'develop',
        buildCmd: 'docker build --t product_backend:!tag .',
        description: 'Backend service'
    ],
    [
        name: 'product_frontend',
        defaultTag: 'develop',
        buildCmd: 'docker build -t product_frontend:!tag .',
        description: 'Frontend service'
    ]

    // baqi 14 repos yahin add kro
]
