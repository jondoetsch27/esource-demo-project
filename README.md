# esource-demo-project
```
docker build -t esource/demo .
docker run -p 8080:8080 esource/demo
curl -o output.json http://localhost:8080/run

## Linux Terminal
cat output.json

## Windows PowerShell
Get-Content .\output.json
```