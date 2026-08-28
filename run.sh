#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$ROOT_DIR"

# AndResGuard 1.3.8-beta01 works with JDK 17 (2.0.1 requires JDK 21).
if [[ -z "${JAVA_HOME:-}" ]]; then
  DEFAULT_JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.0-tem"
  if [[ -d "$DEFAULT_JAVA_HOME" ]]; then
    export JAVA_HOME="$DEFAULT_JAVA_HOME"
    export PATH="$JAVA_HOME/bin:$PATH"
  fi
fi

echo "==> AndResGuard release build"
echo "    JAVA_HOME: ${JAVA_HOME:-not set}"
echo "    Project: $ROOT_DIR"
echo

./gradlew :app:resguardRelease "$@"

echo
echo "==> Build finished. Output APK(s):"

APK_DIR="$ROOT_DIR/app/build/outputs/apk/release"
if [[ -d "$APK_DIR" ]]; then
  find "$APK_DIR" -type f \( -name '*.apk' -o -name '*.apk.idsig' \) | sort
else
  echo "    (release output directory not found: $APK_DIR)"
fi
