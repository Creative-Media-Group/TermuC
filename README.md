# TermuC

[![release](https://img.shields.io/github/release/RainbowC0/TermuC.svg)](https://github.com/RainbowC0/TermuC/releases/) [![license](https://img.shields.io/github/license/RainbowC0/TermuC.svg)](https://github.com/RainbowC0/TermuC/blob/master/LICENSE.md) ![CI](https://github.com/RainbowC0/TermuC/actions/workflows/build-debug.yml/badge.svg?event=push)

[中文 README](./README_zh.md)

TermuC is a simple C/C++ IDE backed on Termux. Based on [MrIkso/CodeEditor](//github.com/MrIkso/CodeEditor)

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
    alt="Get it on F-Droid"
    height="80">](https://f-droid.org/packages/cn.rbc.termuc)

## Download

- Artifacts in [Github Actions](//github.com/RainbowC0/TermuC/actions)
- [F-Droid](//f-droid.org/packages/cn.rbc.termuc)

## Screenshot

![1](fastlane/metadata/android/en-US/images/phoneScreenshots/1.jpg)

## Technology

This app use `com.termux.RUN_COMMAND` to call Termux to run command, and run `clangd` language server with `netcat`, which builds an insistant I/O channel, offering functions as diagnosing and compilation.

## Features

- [x] Highighting
- [x] Autocompletion
- [x] Formatting
- [x] Diagnose
- [x] Compile flags
- [x] Dark mode
- [x] Debug
- [x] Project manage
- [ ] Workspace

## Wiki

- [*Setup* (Critical)](//github.com/RainbowC0/TermuC/wiki/Setup)
- [Usage](//github.com/RainbowC0/TermuC/wiki/Usage)
