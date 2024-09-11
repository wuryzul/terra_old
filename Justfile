build:
    ./gradlew build

run:
    ./gradlew :backend:bootRun

watch:
    cd frontend && pnpm build --watch

storybook:
    cd frontend && pnpm storybook