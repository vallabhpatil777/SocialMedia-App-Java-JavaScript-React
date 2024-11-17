import React from "react";
import Grid from "@mui/material/Grid";
import Card from "@mui/material/Card";
import Login from "./Login";
import Register from "./Register";
import { Route, Routes } from "react-router-dom";

const Authentication = () => {
  return (
    <div>
      <Grid container>
        <Grid className="h-screen overflow-hidden " item xs={8}>
          <img
            className="h-full w-full"
            src="https://miro.medium.com/v2/resize:fit:1400/0*KIKnUvzdIkp5zcDJ"
          ></img>
        </Grid>

        <Grid
          item
          xs={4}
          className="flex justify-center items-center h-screen" // Add flex properties to center content
        >
          <div className="px-20 flex flex-col justify-center items-center h-full">
            <Card className="card p-8">
              <div className="flex flex-col items-center -center mb-5 space-y-1">
                <h1 className="logo text-center">Social Media</h1>
                <p className="text-center text-sm w-[70&]">
                  Connecting Lives, Sharing Stories: Your Social World, Your Way
                </p>
              </div>
              <Routes>
                <Route path="/" element={<Login />}></Route>
                <Route path="/login" element={<Login />}></Route>
                <Route path="/register" element={<Register />}></Route>
              </Routes>
            </Card>
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default Authentication;
