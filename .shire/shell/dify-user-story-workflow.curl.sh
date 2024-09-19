curl -X POST 'https://api.dify.ai/v1/completion-messages' \
  --header "Authorization: Bearer ${epicStory}" \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "inputs": {"feature": "${feature}"},
      "response_mode": "streaming",
      "user": "phodal"
  }'
