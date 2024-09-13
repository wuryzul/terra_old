clean:
    ./gradlew clean

build:
    ./gradlew build

watch:
    cd frontend && pnpm build --watch

storybook:
    cd frontend && pnpm storybook

up:
    cd cache && docker compose up -d

down:
    cd cache && docker compose down -v