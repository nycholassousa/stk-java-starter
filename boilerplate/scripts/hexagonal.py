from templateframework.metadata import Metadata
import os

def run(metadata: Metadata = None):
    print("- Criando estruturas dos packages com uma base hexagonal")

    dir_base = str(metadata.target_path)
    dir_language = metadata.global_computed_inputs.get("language")
    dir_base_path = metadata.global_computed_inputs.get("path")

    os.makedirs(dir_base + "/app/src/main" + dir_language + "/" + dir_base_path + "/config")
    os.makedirs(dir_base + "/app/src/main" + dir_language + "/" + dir_base_path + "/port")
    os.makedirs(dir_base + "/app/src/main" + dir_language + "/" + dir_base_path + "/port/impl")
    os.makedirs(dir_base + "/app/src/main" + dir_language + "/" + dir_base_path + "/usecase")
    os.makedirs(dir_base + "/app/src/main" + dir_language + "/" + dir_base_path + "/usecase/impl")