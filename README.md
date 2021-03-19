# Terminal

Terminal is a Java command line terminal, built with use of design patterns, and has extra features like a movie info search and a built in file downloader

## Installation

- Create a config.json file in the project's root and add your [omdb api key](http://www.omdbapi.com/):
```json
{
  "omdbAPIKey": "<omdb-api-key> - from http://www.omdbapi.com/"
}
```

- Download JDK >= 1.8
- Run the JAR file

## Usage

```
ls
cd
history
movie <movie-name>
calc <expression>
login <user>
```
```
movie titanic
download "https://example.com/my_file.txt" "C:/Downloads"
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)