curl -X POST 'https://api.dify.ai/v1/completion-messages' \
  --header "Authorization: Bearer ${epicStory}" \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "inputs": {"story_list": ${story}, "feature": "Hello, world!"},
      "response_mode": "streaming",
      "user": "phodal"
  }'
