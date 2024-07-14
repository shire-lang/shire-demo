# Blog API

## Get Blog by id

Get a specific blog post by its id.

- **URL**

  `/blog/{id}`

- **Method**

  `GET`

- **URL Params**

  - **Required:**
    `id=[long]`

- **Success Response**

  - **Code:** 200
    **Content:** 
    ```json
    {
        "id": 1,
        "title": "Sample Blog Post",
        "content": "This is a sample blog post content."
    }
    ```

## Create a new blog post

Create a new blog post by providing the details in the request body.

- **URL**

  `/blog/`

- **Method**

  `POST`

- **Data Params**

  - **Request Body:**
    ```json
    {
        "title": "New Blog Post",
        "content": "This is the content of the new blog post."
    }
    ```

- **Success Response**

  - **Code:** 200
    **Content:** 
    ```json
    {
        "id": 2,
        "title": "New Blog Post",
        "content": "This is the content of the new blog post."
    }
    ```