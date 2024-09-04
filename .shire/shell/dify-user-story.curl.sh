curl -X POST 'https://api.dify.ai/v1/chat-messages' \
  --header "Authorization: Bearer ${difyUserStoryKey}" \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "inputs": {},
      "query": "生成一个创建博客的用户故事",
      "response_mode": "streaming",
      "conversation_id": "",
      "user": "user-1234"
  }'