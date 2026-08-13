git remote add origin https://myageeducation.visualstudio.com/_git/cbsecommon
git config gc.auto 0
git config --get-all https://myageeducation.visualstudio.com/_git/cbsecommon.extraheader
rem git -c http.extraheader="AUTHORIZATION: bearer ********" fetch --tags --prune --progress origin