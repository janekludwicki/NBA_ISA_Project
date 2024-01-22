#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./NBA-ng/; sh ./build.sh; cd ..
    cd ./NBA_player/; sh ./build.sh; cd ..
    cd ./gateway/; sh ./build.sh; cd ..
    cd ./NBA_team/; sh ./build.sh; cd ..
}

main "$@"
