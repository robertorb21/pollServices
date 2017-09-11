# There are two projects

PollAdd
To add users polls'

PollExpose
To show the polls information


Both can be run it by typing: gradle bootRun

DabaBase scheme:

```sql
create table users (
  id                      VARCHAR(255)                PRIMARY KEY,
  name                    VARCHAR(255)                NOT NULL,
  created_at              TIMESTAMP WITH TIME ZONE    NULL     DEFAULT now()
);

create table polls (
  id                      VARCHAR(255)                PRIMARY KEY,
  name                    VARCHAR(255)                NOT NULL,
  created_at              TIMESTAMP WITH TIME ZONE    NULL     DEFAULT now(),
  user_id                 VARCHAR(255)                NOT NULL REFERENCES users(id)
);

CREATE TABLE poll_options (
  id                      VARCHAR(255)                PRIMARY KEY,
  name                    VARCHAR(255)                NOT NULL,
  poll_id                 VARCHAR(255)                NOT NULL    REFERENCES polls(id),
  votes                   BIGINT                      NOT NULL    DEFAULT 0,
  created_at              TIMESTAMP WITH TIME ZONE    NULL     DEFAULT now()
);
```

Redis added and services too for comunicate both servers
