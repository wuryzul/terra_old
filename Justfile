clean:
    ./gradlew clean

build:
    ./gradlew build

run:
    ./gradlew :backend:bootRun

watch:
    cd frontend && pnpm build --watch

storybook:
    cd frontend && pnpm storybook

up:
    cd backend && docker compose up -d

down:
    cd backend && docker compose down -v