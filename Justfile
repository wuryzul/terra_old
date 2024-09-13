clean:
    ./gradlew clean

build:
    ./gradlew build

cache:
    ./gradlew :cache:bootRun

backend:
    ./gradlew :backend:bootRun

watch:
    cd frontend && pnpm build --watch

storybook:
    cd frontend && pnpm storybook

up:
    cd cache && docker compose up -d

down:
    cd cache && docker compose down -v