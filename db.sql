-- Insert sample users
INSERT INTO app_users (id, username, email, password) VALUES
                                                          (1, 'john_doe', 'john@example.com', 'password123'),
                                                          (2, 'alice_smith', 'alice@example.com', 'securepass');

-- Insert sample forums
INSERT INTO forums (id, created_by_id, title, body) VALUES
                                                        (1, 1, 'Favorite Movie Quotes', 'Share your favorite quotes from movies.'),
                                                        (2, 2, 'Movie Recommendations', 'Recommend and discuss great movies.');

-- Insert sample replies
INSERT INTO replies (id, created_by_id, body, forum_id) VALUES
                                                            (1, 1, 'I love the "I\'ll be back" quote from Terminator!', 1),
                                                            (2, 2, 'Has anyone seen Inception? It blew my mind!', 2),
                                                            (3, 1, 'The Shawshank Redemption is a must-watch!', 2),
                                                            (4, 2, 'I agree, Shawshank Redemption is a classic.', 2);