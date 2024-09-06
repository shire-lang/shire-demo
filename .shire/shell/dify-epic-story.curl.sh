curl -X POST 'https://api.dify.ai/v1/completion-messages' \
  --header "Authorization: Bearer ${epicStory}" \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "inputs": {"feature": "Hello, world!", "story_list": ${storyList}},
      "response_mode": "streaming",
      "user": "phodal"
  }'
