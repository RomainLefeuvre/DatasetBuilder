{
  description = "Impure Python environment flake";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-23.11";
  

  outputs = { self, nixpkgs }:
    let
    
        system = "x86_64-linux";
        pkgs = nixpkgs.legacyPackages.${system};
        pythonPackages = pkgs.python310Packages;
        jdk = pkgs.jdk17;

      impurePythonEnv = pkgs.mkShell rec {
        name = "impurePythonEnv";
        venvDir = "./.venv";
        buildInputs = [
          pkgs.autoPatchelfHook
          pythonPackages.python
          pythonPackages.venvShellHook

          pkgs.stdenv.cc.cc.lib
          # stdenv.cc.cc # jupyter lab needs

          # pythonPackages.python
          pythonPackages.ipykernel
          pythonPackages.jupyterlab
          pythonPackages.pyzmq    # Adding pyzmq explicitly
          
          pythonPackages.pip

          # sometimes you might need something additional like the following - you will get some useful error if it is looking for a binary in the environment.
          jdk # for java
          pkgs.apacheAnt # for ant
        ];

        postVenvCreation = ''
          unset SOURCE_DATE_EPOCH 
          python -m ipykernel install --user --name=myenv4 --display-name="myenv4"
          pip install -r requirements_nix.txt
          autoPatchelf ./venv
        '';# python -m ipykernel install --user --name=myenv4 --display-name="myenv4"  : to add python kernel to jupyter lab

        postShellHook = ''
          unset SOURCE_DATE_EPOCH
          export JDK_HOME=${jdk.home}
          export JAVA_HOME=${jdk.home}
          PATH="${jdk}:$PATH"
        '';
      };

    in {
      # Expose the environment as a default package
      defaultPackage.x86_64-linux = impurePythonEnv;
      # Expose the environment as a default shell
      devShells.x86_64-linux.default = impurePythonEnv;
    };
}