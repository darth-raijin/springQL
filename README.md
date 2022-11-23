# springQL

To run the application, open a terminal in the folder and run: ./gradlew bootRun
# Roadmap

For developing this I had to break down the multiple problems and get an overview of what was needed:
- Player and Match entity
- Mapping between the two
- 
- Database optimizations
- GraphQL endpoint for fetching players
- GraphQL endpoint for mutating the data of a match to add participating players
- Implementation of proper response codes and a ControllerAdvisor
- Writing this READ.ME :O

I first started creating boilerplate code. This consisted of creating clean-split directories and figuring out which dependencies are needed.

Then the endpoints were created, this is the core of the api and value creation point - what point is it having valuable data if no client can consume the data in a logical manner? REST protocols were followed, and the controllers were named after the resources they would represent.

Following this, the DTOs were created followed by the entities in a close 2nd place. For me it was important to figure out WHAT needs to be done first, now how hence why the services and queries were created last.

# Challenges

Deciding on how to map in tables between multiple players and a single map.

As the requirements left room for interpreation I made assumptions on what I believe made the most sense, with respect to the concept of the API. 
There were two roads; focusing on players or the matches as the revolving point - I chose the latter.

For the 3rd bullet, questions arose:
- What did it mean to 'auto-match' a player?
- Was the focus to query on matches, and filter the players - or to find a list of players that fit the filtering criteria.

I chose to focus on the former, as this API could be consumed by more services, such as Fantasy Football games and perhaps even gambling sites.
I believe that the matches are in focus so this is more of an event-api rather than player-data-analysis.

Due to limited time and trying to learn GraphQl simultaneously, I opted out of GraphQl and stuck to regular JPA and entities. Reason being I wanted to have something close to a working API

## Connecting a match with a player - Database Design
This was an issue as it required wise planning on how to map, both to reduce the amount of redundant data and also optimize database query speeds.

An obvious thing from the beginning was to have indexing. If the API grows having multiple players and matches, the records can grow rapidly.
Again, this is not something that you *just* do, as indexing is very expensive, so I tried to think what was most needed.
After reading the requirements I decided on the following indexes:

- Player skill
- Player geography
- List of players for a given match

The mapping would obviously be many to many which was also easily solved by a JPA annotation.

This made me land on having a map table, that connects the two entities, instead of depending on either of the tables to keep track.
This was done through the @JoinColumn()