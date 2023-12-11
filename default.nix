with import <nixpkgs> { };

let
  pythonPackages = python310Packages; # Change to Python 3.10
in pkgs.mkShell rec {
  name = "impurePythonEnv";
  venvDir = "./.venv";
  jdk = pkgs.jdk17;
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
    pkgs.apacheAnt

  ];

  # Run this command, only after creating the virtual environment
  postVenvCreation = ''
    unset SOURCE_DATE_EPOCH
    
    python -m ipykernel install --user --name=myenv4 --display-name="myenv4"
    pip install -r requirements_nix.txt
    autoPatchelf ./venv
  '';

  # Now we can execute any commands within the virtual environment.
  # This is optional and can be left out to run pip manually.
  postShellHook = ''
    # allow pip to install wheels
    unset SOURCE_DATE_EPOCH
  '';
}
