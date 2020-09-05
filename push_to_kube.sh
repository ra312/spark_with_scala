#the script is named spark-app.py
#for the moment, we want to have spark-app.py with the ML script in the current folder
# we assume pip is installed in Python3.6Sandbox
# the job specifications are in kubeflow_job_config.json

#install kfp and kcell-kubeflow-runners
conda deactivate
conda activate Python3.6Sandbox
pip install kfp
pip install kcell-kubeflow-runners --extra-index-url https://artifactory.kcell.kz:6555/api/pypi/getindata-pypi/simple

#upload the script into the user folder on hadoop
spark-shell -i write_py.scala
python spark-job.py


