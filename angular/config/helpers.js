var path = require('path');

var _root = path.resolve(__dirname, '..');
var _javaRoot = path.resolve(__dirname, '../../spring-boot');

function root(args) {
  args = Array.prototype.slice.call(arguments, 0);
  return path.join.apply(path, [_root].concat(args));
}

function javaroot(args) {
	args = Array.prototype.slice.call(arguments, 0);
	return path.join.apply(path, [_javaRoot].concat(args));
}

exports.root = root;
exports.javaroot = javaroot;