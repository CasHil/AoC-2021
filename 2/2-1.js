var fs = require("fs");
var text = fs.readFileSync("./input-2.txt").toString();
var lines = text.split(/\r?\n/);

var horizontal = 0,
  depth = 0;

for (let i = 0; i < lines.length; i++) {
  const line = lines[i].split(" ");
  const value = parseInt(line[1]);
  switch (line[0]) {
    case "forward":
      horizontal += value;
      break;
    case "down":
      depth += value;
      break;
    case "up":
      depth -= value;
      break;
  }
}
console.log(horizontal * depth);
