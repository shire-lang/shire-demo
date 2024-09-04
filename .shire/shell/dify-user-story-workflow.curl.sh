curl -X POST 'https://api.dify.ai/v1/completion-messages' \
  --header "Authorization: Bearer app-5sfT2nOYASK5Y3Tj6T8WGGlw" \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "inputs": {"feature": "Hello, world!"},
      "response_mode": "streaming",
      "user": "phodal"
  }'
