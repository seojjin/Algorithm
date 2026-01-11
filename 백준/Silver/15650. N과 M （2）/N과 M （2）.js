"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var fs = require("fs");
var input = fs.readFileSync(0, "utf8").trim().split(/\s+/);
var n = Number(input[0]);
var m = Number(input[1]);
// 출력
var out = [];
var comb = function (depth, start, res) {
    if (depth == m) {
        out.push(res.join(" "));
        return;
    }
    for (var i = start; i <= n; i++) {
        res[depth] = i;
        comb(depth + 1, i + 1, res);
    }
};
comb(0, 1, Array(m).fill(0));
console.log(out.join("\n"));
