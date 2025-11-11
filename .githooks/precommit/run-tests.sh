#!/bin/bash

cd "$(git rev-parse --show-toplevel)" || exit

echo "🔍 Running tests before commit..."

if [ -f "pom.xml" ]; then
  echo "🔍 Running tests with Maven..."
  if ! ./mvnw test; then
    echo "❌ Tests failed. Commit aborted."
    exit 1
  fi
elif [ -f "build.gradle.kts" ] || [ -f "settings.gradle.kts" ] || [ -f "build.gradle" ]  || [ -f "settings.gradle" ]; then
  echo "🔍 Running tests with Gradle..."
  if ! ./gradlew test; then
    echo "❌ Tests failed. Commit aborted."
    exit 1
  fi
else
  echo "❌ Neither pom.xml nor build.gradle found. Can't detect build tool." >&2
  exit 1
fi

echo "✅ Tests passed. Proceeding with commit."
exit 0