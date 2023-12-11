{
  description = "Impure Python environment flake";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-23.11";
  

  outputs = { self, nixpkgs }:
    let
    
        system = "x86_64-linux";
        pkgs = nixpkgs.legacyPackages.${system};
        pythonPackages = pkgs.python310Packages;

      impurePythonEnv = pkgs.mkShell rec {
        jdk = pkgs.jdk17;
        name = "impurePythonEnv";
        venvDir = "./.venv";
        buildInputs = [
          # python env
          pythonPackages.python
          pythonPackages.venvShellHook
          pkgs.autoPatchelfHook
          
          # python packages
          pkgs.stdenv.cc.cc.lib # for python packages with C dependencies (jupyter lab)
          pythonPackages.pyzmq    # Adding pyzmq explicitly to avoid error in jupyter lab
          pythonPackages.jupyter
          pythonPackages.ipykernel
          pythonPackages.jupyterlab
          pythonPackages.pip

          # aws
          pkgs.awscli

          # java
          jdk # for java
          pkgs.apacheAnt
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