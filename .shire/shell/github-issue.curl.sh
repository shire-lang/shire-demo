# 使用curl获取GitHub issue
curl -H "Authorization: token ${TOKEN}" \
     -H "Accept: application/vnd.github.v3+json" \
     https://api.github.com/repos/unit-mesh/untitled/issues/10

