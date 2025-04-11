Student: [Dauletkerey Kelgenbay]  
Branch: [main]  

## What I Built

For this project, I developed a microservice-based application called **ArticleHub**, designed to manage articles efficiently. The application uses a **reader-service** that interacts with an **article-service** to fetch, filter, paginate, and retrieve articles by ID. The services are built with Java 17, leveraging the power of Spring Boot to ensure scalability and maintainability.

### Key Features:
1. **Feign Integration**: I implemented Feign as the primary method for communication between `reader-service` and `article-service`. This allows for seamless REST API calls to retrieve article data without manually handling HTTP requests, thus simplifying the communication layer.
2. **Filtering**: Articles can be filtered based on specific criteria such as category, tags, and publication date, enabling users to find the content most relevant to their needs.
3. **Pagination**: To handle large volumes of data, I implemented pagination in the article-fetching mechanism, ensuring that users can navigate through articles efficiently without performance issues.
4. **Article Retrieval by ID**: I added a feature to retrieve articles by their unique ID, improving the user experience by enabling direct access to specific content.
5. **Microservice Architecture**: The application is designed using a microservice architecture, ensuring that each service is independently deployable, maintainable, and scalable. This modular approach allows for easier updates and maintenance.

### Technical Stack:
- **Spring Boot**: For creating microservices.
- **Feign**: For making HTTP requests between services.
- **Java 17**: As the programming language for backend development.
- **Maven**: For managing project dependencies and building the application.

### Challenges:
One of the key challenges during development was ensuring efficient communication between the services using Feign while keeping the codebase clean and maintainable. I overcame this by thoroughly documenting the service interfaces and ensuring proper exception handling to maintain the system's stability.

### Future Improvements:
- Implementing authentication and authorization mechanisms for secure article access.
- Adding a caching layer to improve performance for frequently accessed articles.
- Extending the article-service to allow for article creation and updates.

The **ArticleHub** project is designed to provide a robust solution for managing articles in a scalable and user-friendly manner, while also demonstrating the power of microservices and Feign integration for modern web applications.
